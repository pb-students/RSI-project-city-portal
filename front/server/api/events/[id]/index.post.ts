import type { EventInfo } from "~/types";

export default defineEventHandler(async (event) => {
  const id = parseInt(event.context.params?.id ?? "0") as number;
  const body = await readBody(event);
  console.log(body)
  const client = await useSoapClient();
  return getSoapData<EventInfo>(client.updateEventAsync({ id, ...body }));
});

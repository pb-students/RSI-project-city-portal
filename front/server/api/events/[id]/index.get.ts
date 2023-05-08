import type { EventInfo } from "~/types";

export default defineEventHandler(async (event) => {
  const id = parseInt(event.context.params?.id ?? "0") as number;
  const client = await useSoapClient();
  return getSoapData<EventInfo>(client.getEventByIdAsync({ id }));
});

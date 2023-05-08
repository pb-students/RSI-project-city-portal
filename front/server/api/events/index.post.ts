import type { EventInfo } from "~/types";

export default defineEventHandler(async (event) => {
  const client = await useSoapClient();
  const body = await readBody(event);
  return getSoapData<EventInfo>(client.addEventAsync(body));
});

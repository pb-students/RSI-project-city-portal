import type { EventInfo } from "~/types";

export default defineEventHandler(async (event) => {
  const client = await useSoapClient();
  return getSoapData<EventInfo[]>(client.getAllEventsAsync({}));
});

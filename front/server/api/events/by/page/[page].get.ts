import type { EventInfo } from "~/types";

export default defineEventHandler(async (event) => {
  const page = parseInt(event.context.params?.page ?? "0") as number;
  const client = await useSoapClient();
  return getSoapData<EventInfo[]>(client.getPaginatedEventsAsync({ page }), []);
});

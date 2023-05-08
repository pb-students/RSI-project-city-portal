import type { EventInfo } from "~/types";

export default defineEventHandler(async (event) => {
  const [date] = new Date(event.context.params?.date).toISOString().split("T");
  const client = await useSoapClient();
  return getSoapData<EventInfo[]>(client.getEventsForWeekAsync({ date }), []);
});

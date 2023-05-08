export default defineEventHandler(async (event) => {
  const client = await useSoapClient();

  return (
    "data:application/pdf;base64," +
    (await getSoapData(client.generatePdfAsync({})))
  );
});

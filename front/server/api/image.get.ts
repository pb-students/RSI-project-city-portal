import soap from "soap";
import { fileURLToPath } from "url";

export default defineEventHandler(async (event) => {
  const client = await soap.createClientAsync(
    fileURLToPath(
      new URL("../../../src/main/resources/service.wsdl", import.meta.url)
    )
  );

  const query = getQuery(event);
  const [{ return: base64 }] = await client.getImageAsync({
    arg0: query.file ?? "image.png",
  });

  return Buffer.from(base64, "base64");
});

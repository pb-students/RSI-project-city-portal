import soap from "soap";
import { fileURLToPath } from "url";

export const useSoapClient = async () =>
  soap.createClientAsync(
    fileURLToPath(
      new URL("../../../src/main/resources/service.wsdl", import.meta.url)
    )
  );

type SoapResponse<T> = [null | { return: T }];

export async function getSoapData<T>(
  promise: SoapResponse<T> | Promise<SoapResponse<T>>,
  defaultValue: T
): Promise<T>;

export async function getSoapData<T>(
  promise: SoapResponse<T> | Promise<SoapResponse<T>>
): Promise<T | null>;

export async function getSoapData<T>(
  promise: SoapResponse<T> | Promise<SoapResponse<T>>,
  defaultValue: T | null = null
): Promise<T | null> {
  const data = (await promise)?.[0]?.return;

  if (!data) console.error("SOAP request failed:", await promise);

  return data ?? defaultValue;
}

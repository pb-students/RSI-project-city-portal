import { Client as SoapClient, createClientAsync as soapCreateClientAsync } from "soap";
import { TnsgetPaginatedEvents } from "./definitions/TnsgetPaginatedEvents";
import { TnsgetPaginatedEventsResponse } from "./definitions/TnsgetPaginatedEventsResponse";
import { TnsgetEventById } from "./definitions/TnsgetEventById";
import { TnsgetEventByIdResponse } from "./definitions/TnsgetEventByIdResponse";
import { TnsgeneratePdf } from "./definitions/TnsgeneratePdf";
import { TnsgeneratePdfResponse } from "./definitions/TnsgeneratePdfResponse";
import { TnsaddEvent } from "./definitions/TnsaddEvent";
import { TnsaddEventResponse } from "./definitions/TnsaddEventResponse";
import { TnsupdateEvent } from "./definitions/TnsupdateEvent";
import { TnsupdateEventResponse } from "./definitions/TnsupdateEventResponse";
import { TnsdeleteEvent } from "./definitions/TnsdeleteEvent";
import { TnsdeleteEventResponse } from "./definitions/TnsdeleteEventResponse";
import { TnsgetAllEvents } from "./definitions/TnsgetAllEvents";
import { TnsgetAllEventsResponse } from "./definitions/TnsgetAllEventsResponse";
import { TnsgetEventsForDay } from "./definitions/TnsgetEventsForDay";
import { TnsgetEventsForDayResponse } from "./definitions/TnsgetEventsForDayResponse";
import { TnsgetEventsForWeek } from "./definitions/TnsgetEventsForWeek";
import { TnsgetEventsForWeekResponse } from "./definitions/TnsgetEventsForWeekResponse";
import { CityInformationService } from "./services/CityInformationService";

export interface ServiceClient extends SoapClient {
    CityInformationService: CityInformationService;
    getPaginatedEventsAsync(getPaginatedEvents: TnsgetPaginatedEvents): Promise<[result: TnsgetPaginatedEventsResponse, rawResponse: any, soapHeader: any, rawRequest: any]>;
    getEventByIdAsync(getEventById: TnsgetEventById): Promise<[result: TnsgetEventByIdResponse, rawResponse: any, soapHeader: any, rawRequest: any]>;
    generatePdfAsync(generatePdf: TnsgeneratePdf): Promise<[result: TnsgeneratePdfResponse, rawResponse: any, soapHeader: any, rawRequest: any]>;
    addEventAsync(addEvent: TnsaddEvent): Promise<[result: TnsaddEventResponse, rawResponse: any, soapHeader: any, rawRequest: any]>;
    updateEventAsync(updateEvent: TnsupdateEvent): Promise<[result: TnsupdateEventResponse, rawResponse: any, soapHeader: any, rawRequest: any]>;
    deleteEventAsync(deleteEvent: TnsdeleteEvent): Promise<[result: TnsdeleteEventResponse, rawResponse: any, soapHeader: any, rawRequest: any]>;
    getAllEventsAsync(getAllEvents: TnsgetAllEvents): Promise<[result: TnsgetAllEventsResponse, rawResponse: any, soapHeader: any, rawRequest: any]>;
    getEventsForDayAsync(getEventsForDay: TnsgetEventsForDay): Promise<[result: TnsgetEventsForDayResponse, rawResponse: any, soapHeader: any, rawRequest: any]>;
    getEventsForWeekAsync(getEventsForWeek: TnsgetEventsForWeek): Promise<[result: TnsgetEventsForWeekResponse, rawResponse: any, soapHeader: any, rawRequest: any]>;
}

/** Create ServiceClient */
export function createClientAsync(...args: Parameters<typeof soapCreateClientAsync>): Promise<ServiceClient> {
    return soapCreateClientAsync(args[0], args[1], args[2]) as any;
}

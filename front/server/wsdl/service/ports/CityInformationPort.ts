import { TnsgetPaginatedEvents } from "../definitions/TnsgetPaginatedEvents";
import { TnsgetPaginatedEventsResponse } from "../definitions/TnsgetPaginatedEventsResponse";
import { TnsgetEventById } from "../definitions/TnsgetEventById";
import { TnsgetEventByIdResponse } from "../definitions/TnsgetEventByIdResponse";
import { TnsgeneratePdf } from "../definitions/TnsgeneratePdf";
import { TnsgeneratePdfResponse } from "../definitions/TnsgeneratePdfResponse";
import { TnsaddEvent } from "../definitions/TnsaddEvent";
import { TnsaddEventResponse } from "../definitions/TnsaddEventResponse";
import { TnsupdateEvent } from "../definitions/TnsupdateEvent";
import { TnsupdateEventResponse } from "../definitions/TnsupdateEventResponse";
import { TnsdeleteEvent } from "../definitions/TnsdeleteEvent";
import { TnsdeleteEventResponse } from "../definitions/TnsdeleteEventResponse";
import { TnsgetAllEvents } from "../definitions/TnsgetAllEvents";
import { TnsgetAllEventsResponse } from "../definitions/TnsgetAllEventsResponse";
import { TnsgetEventsForDay } from "../definitions/TnsgetEventsForDay";
import { TnsgetEventsForDayResponse } from "../definitions/TnsgetEventsForDayResponse";
import { TnsgetEventsForWeek } from "../definitions/TnsgetEventsForWeek";
import { TnsgetEventsForWeekResponse } from "../definitions/TnsgetEventsForWeekResponse";

export interface CityInformationPort {
    getPaginatedEvents(getPaginatedEvents: TnsgetPaginatedEvents, callback: (err: any, result: TnsgetPaginatedEventsResponse, rawResponse: any, soapHeader: any, rawRequest: any) => void): void;
    getEventById(getEventById: TnsgetEventById, callback: (err: any, result: TnsgetEventByIdResponse, rawResponse: any, soapHeader: any, rawRequest: any) => void): void;
    generatePdf(generatePdf: TnsgeneratePdf, callback: (err: any, result: TnsgeneratePdfResponse, rawResponse: any, soapHeader: any, rawRequest: any) => void): void;
    addEvent(addEvent: TnsaddEvent, callback: (err: any, result: TnsaddEventResponse, rawResponse: any, soapHeader: any, rawRequest: any) => void): void;
    updateEvent(updateEvent: TnsupdateEvent, callback: (err: any, result: TnsupdateEventResponse, rawResponse: any, soapHeader: any, rawRequest: any) => void): void;
    deleteEvent(deleteEvent: TnsdeleteEvent, callback: (err: any, result: TnsdeleteEventResponse, rawResponse: any, soapHeader: any, rawRequest: any) => void): void;
    getAllEvents(getAllEvents: TnsgetAllEvents, callback: (err: any, result: TnsgetAllEventsResponse, rawResponse: any, soapHeader: any, rawRequest: any) => void): void;
    getEventsForDay(getEventsForDay: TnsgetEventsForDay, callback: (err: any, result: TnsgetEventsForDayResponse, rawResponse: any, soapHeader: any, rawRequest: any) => void): void;
    getEventsForWeek(getEventsForWeek: TnsgetEventsForWeek, callback: (err: any, result: TnsgetEventsForWeekResponse, rawResponse: any, soapHeader: any, rawRequest: any) => void): void;
}

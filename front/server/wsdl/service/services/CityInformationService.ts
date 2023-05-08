import { CityInformationPort } from "../ports/CityInformationPort";

export interface CityInformationService {
    readonly CityInformationPort: CityInformationPort;
}

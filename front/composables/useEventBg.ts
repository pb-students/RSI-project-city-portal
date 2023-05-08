import { EventInfo } from "~/types";

const images = ["/1.jpg", "/2.jpg", "/3.jpg", "/4.jpg", "/5.jpg", "/6.jpg"];

export default (event: EventInfo) => {
  return images[event.id % images.length];
};

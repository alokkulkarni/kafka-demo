export class Message {

    constructor(
        public ID: string,
        public vendorName: string,
        public location: string,
        public currency: string,
        public amount: string,
        public transTime: string
    ) { }   
}
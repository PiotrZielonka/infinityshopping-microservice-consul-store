import { IStore, NewStore } from './store.model';

export const sampleWithRequiredData: IStore = {
  id: 23647,
  name: 'noisily drat',
  location: 'oof overdub',
  phoneNumber: 'indeed drab',
};

export const sampleWithPartialData: IStore = {
  id: 6928,
  name: 'because',
  location: 'connect',
  phoneNumber: 'toward',
};

export const sampleWithFullData: IStore = {
  id: 9173,
  name: 'twine blah tattered',
  location: 'forgo gray officially',
  phoneNumber: 'anti',
};

export const sampleWithNewData: NewStore = {
  name: 'immense',
  location: 'sadly hoot bungalow',
  phoneNumber: 'eek now',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

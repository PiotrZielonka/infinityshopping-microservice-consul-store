export interface IStore {
  id: number;
  name?: string | null;
  location?: string | null;
  phoneNumber?: string | null;
}

export type NewStore = Omit<IStore, 'id'> & { id: null };

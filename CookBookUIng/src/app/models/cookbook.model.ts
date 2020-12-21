import { Recipe } from "./recipe.model";

export interface Cookbook {
    id:number;
    name:String;
    author :String;
    featured :Boolean;
    coverImage: File;
    recipeDtos: Recipe[];
}

export interface Recipe {
    
    id : number;
    name : string;
    author : string;
    featured : boolean;
    servings : number;
    prepTime : number;
    cookTime : number;
    steps : string;
    tags : string;
    ingredients : string;
    description : string;
    recipeImage: File;
}
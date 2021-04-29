package lab111.stepancj;


public interface Comparator <K> {
    //
    //  Used for a comparison based on an ordering 
    //  other than the "natural ordering" 
    //   
    //  return < 0 if a < b
    //  return   0 if a = b
    //  return > 0 if a > b
    int compare( K a, K b );
    
}

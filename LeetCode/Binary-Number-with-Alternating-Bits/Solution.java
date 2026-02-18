function bitSolution(number){
    //      10101010101
    //  +    1010101010    ( number >> 1 )
    //  ---------------
    //  =   11111111111
    //  &  100000000000
    //  ---------------
    //  =             0    ( power of two )
    let tmp = ( number >> 1 ) + number;
    return (tmp & tmp + 1) === 0;
}
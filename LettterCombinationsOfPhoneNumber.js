 //Letter Combinations of a Phone Number

/*
*
*
*Given a string containing digits from 2-9 inclusive, return all possible 
*letter combinations that the number could represent. Return the answer in any order.
*A mapping of digits to letters (just like on the telephone buttons) is given below. 
*Note that 1 does not map to any letters.
*
*
*
*/

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if (digits === "") return [];
    var res = [];
    var arr = [ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" ];
    var digits = Array.from( digits );
    function dfs( str, idx ){
        if( str.length === digits.length ){
            res.push( str );
            return;
        }
        var candidates = Array.from(arr[digits[idx]]);
        candidates.forEach(function(i){
            dfs( str + i, idx + 1 )
        })
    }
    dfs( "", 0 );
    return res;
    
};

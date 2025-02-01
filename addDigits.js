class Solution {
    iterate(num) {
        let sumVal = 0;
        const str = String(num); 

        for (let i = 0; i < str.length; i++) {
            const subStr = str.charAt(i);
            const c = parseInt(subStr);
            sumVal += c;
        }

        return sumVal;
    }

    addDigits(num) {
        let res = this.iterate(num);
        while (res >= 10) {
            res = this.iterate(res);
        }
        return res;
    }
}


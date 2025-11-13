function maxOperations(s: string): number {
    let res = 0;
    let oneCount = 0;

    for (let i = 0; i < s.length; i++) {
        if (s[i] == "1") {
            oneCount++;
        } else if (s[i + 1] == "1" || (i + 1) == s.length) {
            res += oneCount;
        }
    }

    return res;
};
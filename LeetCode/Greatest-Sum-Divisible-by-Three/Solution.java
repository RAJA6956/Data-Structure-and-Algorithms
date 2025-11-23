    int sum = 0;

    for (int x : nums) {
        sum += x;
        if (x % 3 == 1) {
            if (x < m11) {
                m12 = m11;
                m11 = x;
            } else if (x < m12) {
                m12 = x;
            }
        } else if (x % 3 == 2) {
            if (x < m21) {
                m22 = m21;
                m21 = x;
            } else if (x < m22) {
                m22 = x;
            }
        }
    }

    if (sum % 3 == 0) return sum;

    if (sum % 3 == 1) {
        int option1 = (m11 != INT_MAX ? m11 : INT_MAX);
        int option2 = (m21 != INT_MAX && m22 != INT_MAX ? m21 + m22 : INT_MAX);
        return sum - min(option1, option2);
    }

    if (sum % 3 == 2) {
        int option1 = (m21 != INT_MAX ? m21 : INT_MAX);
        int option2 = (m11 != INT_MAX && m12 != INT_MAX ? m11 + m12 : INT_MAX);
        return sum - min(option1, option2);
    }

    return sum;
}
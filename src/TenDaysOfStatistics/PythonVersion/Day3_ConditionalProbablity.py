from Tools.Simplifier import Simplifier

def conditonal_prob():
    
    return x, y


if __name__ == '__main__':
    x, y = conditonal_prob()

    value = "{}/{}"

    s = Simplifier()
    s_value, s_value1 = s.fraction_simplifier(x, y)

    print(value.format(s_value, s_value1))
    # print(value.format(x, y))

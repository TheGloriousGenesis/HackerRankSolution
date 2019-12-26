class Simplifier:

    def fraction_simplifier(self, x1, x2):
        gcf = self.greatest_common_factor(x1, x2)
        x2 //= gcf
        x1 //= gcf
        return x1, x2

    # Euclid's Algorithm
    def greatest_common_factor(self, y1, y2):
        values = [y1, y2]
        values.sort()
        lowest_number = values[1] - values[0]
        if lowest_number != 0:
            return self.greatest_common_factor(lowest_number, values[0])
        return values[0]


if __name__ == '__main__':
    top = int(input())
    bottom = int(input())
    s = Simplifier()
    f = s.fraction_simplifier(top, bottom)
    value = "{}/{}"
    print(value.format(f[0], f[1]))

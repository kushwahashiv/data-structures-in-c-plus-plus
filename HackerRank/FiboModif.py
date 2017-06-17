input = raw_input().strip().split()
a = int(input[0])
b = int(input[1])
n = int(input[2])

table = [0, a, b]

if n == 1:
    print a
elif n == 2:
    print b
else:
    t = 3
    while t != n+1:
        table.append(table[t-1] * table[t-1] + table[t-2])
        t += 1
    print table[t-1]

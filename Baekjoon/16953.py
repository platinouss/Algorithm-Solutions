min_value, max_value = map(int, input().split())

count = 1
while len(str(min_value)) != len(str(max_value)):
    if str(max_value)[-1] != '1':
        max_value //= 2
        count += 1
    if str(max_value)[-1] == '1':
        max_value = int(str(max_value)[:-1])
        count += 1

while min_value < max_value:
    if max_value % 2 == 1:
        break
    
    max_value //= 2
    count += 1

if min_value != max_value:
    count = -1

print(count)
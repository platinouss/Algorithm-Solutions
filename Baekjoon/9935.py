def main():
    string = input()
    condition = input()

    stack = []
    length = len(condition)
    last_char_condition = condition[-1]

    for char in string:
        stack.append(char)
        if char == last_char_condition and ''.join(stack[-length:]) == condition:
            del stack[-length:]

    result = ''.join(stack)
    if result == '':
        print('FRULA')
    else:
        print(result)


if __name__ == '__main__':
    main()
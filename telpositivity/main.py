import os

property_list = [
    {'numbers': [99, 44, 22, 77, 66, 88, 11, 90, 40, 20, 70, 60, 80, 10], 'value': 0.5,
     'meaning': '等待 保守 被动 学术'},
    {'numbers': [94, 49, 27, 72, 68, 86, 13, 31], 'value': 1, 'meaning': '财富 聪明 姻缘 善良'},
    {'numbers': [93, 41, 28, 76, 67, 82, 14, 39], 'value': 1, 'meaning': '贵人 人缘 开朗 随缘'},
    {'numbers': [91, 43, 26, 78, 62, 87, 19, 34], 'value': 1, 'meaning': '领导 事业 守财 健康'},
    {'numbers': [92, 47, 29, 74, 61, 83, 16, 38], 'value': 0.5, 'meaning': '桃花 人际 情感 纠葛'},
    {'numbers': [98, 46, 23, 71, 64, 89, 17, 32], 'value': 0.25, 'meaning': '口才 小人 暴躁 病痛'},
    {'numbers': [96, 48, 21, 73, 69, 84, 12, 37], 'value': 0.5, 'meaning': '投资 负债 直爽 孤独'},
    {'numbers': [97, 42, 24, 79, 63, 81, 18, 36], 'value': 0.25, 'meaning': '智慧 才华 变化 凶险'}
]

phone_dict = {}

best_value = -999
best_phone_dict = []


def accept_file_name():
    file_name = input("Enter the country/region of the text file(in short form): ")

    if 'CHI' in file_name.upper() or 'chi' in file_name.lower():

        if os.path.exists(file_name.upper() + '.txt'):
            return file_name.upper()
        elif os.path.exists(file_name.lower() + '.txt'):
            return file_name.lower()
        else:
            print("ERROR: Both 'chi.txt' and 'CHI.txt' does not exist.")

    elif 'HKG' in file_name.upper() or 'hkg' in file_name.lower():

        if os.path.exists(file_name.upper() + '.txt'):
            return file_name.upper()
        elif os.path.exists(file_name.lower() + '.txt'):
            file_name.lower()
        else:
            print("ERROR: Both 'chi.txt' and 'CHI.txt' does not exist.")

    else:
        print("""
            WARN: There is no such options yet. Available options:
            (1) CHI.txt / chi.txt
            (2) HKG.txt / hkg.txt
            """)

    return None


def read_file(file_name):
    file_name += '.txt'
    try:
        with open(file_name, 'r') as file:
            file_content = file.read()
            return file_content
    except FileNotFoundError:
        print("ERROR: File cannot be found.")
    except Exception as e:
        print(f"ERROR： {e}")


def process_file_content(content, locale):
    lines = content.splitlines()

    if locale == 'CHI' or locale == 'chi':
        for line in lines:
            new_line = delete_char_at_index(line, 5)
            pick_best_value(new_line, line)
    elif locale == 'HKG' or locale == 'hkg':
        for line in lines:
            pick_best_value(line)
    else:
        print("WARN: Incorrect locale(file) name.")


def delete_char_at_index(input_string, index_to_delete):
    if 0 <= index_to_delete < len(input_string):
        part_one = input_string[:index_to_delete]
        part_two = input_string[index_to_delete + 1:]

        new_string = part_one + part_two

        return new_string

    else:
        print("WARN: Input String replacement failed.")
        return input_string


def pick_best_value(line, original_line=None):
    global best_value
    global best_phone_dict

    chunks = [line[i:i + 2] for i in range(0, len(line), 2)]
    line_value = 0

    for chunk in chunks:
        for property_line in property_list:
            for number in property_line['numbers']:
                if int(chunk) == number:
                    line_value += property_line['value']

    if best_value < line_value:
        best_value = line_value
        best_phone_dict.clear()
        if original_line is None:
            best_phone_dict.append(line)
        else:
            best_phone_dict.append(original_line)
    elif best_value == line_value:
        if original_line is None:
            best_phone_dict.append(line)
        else:
            best_phone_dict.append(original_line)
    else:
        return

    return


def display_best_phones():
    global best_phone_dict
    global best_value

    print(f"Best Value: {best_value}")
    print(f"Best Phones: {best_phone_dict}")


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    locale = accept_file_name()
    if locale is not None:
        content = read_file(locale)
        process_file_content(content, locale)
        display_best_phones()

    else:
        print("ERROR: Incorrect file name. System Interrupted.")

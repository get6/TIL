class User:
    count = 0

    def __init__(self, name, email, password):
        self.name = name
        self.email = email
        self.password = password

        User.count += 1

    def say_hello(self):
        print(f"안녕하세요! 저는 {self.name}")

    def __str__(self):
        return f"사용자: {self.name}, 이메일: {self.email}, 비밀번호: ******"

    @classmethod
    def number_of_users(cls):
        print(f'총 유저 수는: {cls.count}입니다.')

    @classmethod
    def from_list(cls, list_params):
        name = list_params[0]
        email = list_params[1]
        password = list_params[2]

        # 인스턴스 생성 후 리턴
        return cls(name, email, password)


user1 = User("김대위", "captain@codeit.kr", "12345")

User.say_hello(user1)
user1.say_hello()
print(user1)
print(user1.count)
user1.number_of_users()


def add_print_to(original):
    def wrapper():
        print("함수 시작")
        original()
        print("함수 끝")

    return wrapper


@add_print_to
def print_hello():
    print("Hello Hello")

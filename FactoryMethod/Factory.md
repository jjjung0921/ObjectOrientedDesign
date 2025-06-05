# Factory Method 패턴 설명

## 문제 상황

OS에 따라 다른 버튼을 생성해야 하는 애플리케이션을 생각해보자.

```java
public interface Button {
    void render();
    void onClick(String action);
}

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Windows 버튼을 그립니다.");
    }

    @Override
    public void onClick(String action) {
        System.out.println("Windows 버튼 클릭! " + action);
    }
}

public class HTMLButton implements Button {
    @Override
    public void render() {
        System.out.println("HTML 버튼을 그립니다.");
    }

    @Override
    public void onClick(String action) {
        System.out.println("HTML 버튼 클릭! " + action);
    }
}

public class Application {
    private String os;

    public Application(String os) {
        this.os = os;
    }

    public void renderButton() {
        Button button;

        // 문제: 버튼 생성 로직이 Application 클래스에 직접 포함되어 있다.
        if (os.equalsIgnoreCase("Windows")) {
            button = new WindowsButton();
        } else if (os.equalsIgnoreCase("Web")) {
            button = new HTMLButton();
        } else {
            throw new RuntimeException("Unsupported OS: " + os);
        }

        button.onClick("closeDialog()");
        button.render();
    }
}
```

## OCP 원칙의 위반
`Application` 클래스는 OS에 따라 다른 버튼을 생성한다.  `new` 연산자를 사용하여 객체를 직접 생성하며, 이는 객체 추가/삭제 시 `if-else` 조건문을 수정해야 함을 의미한다. 즉, OCP (Open/Closed Principle)를 위반한다.

## 클라이언트와의 높은 결합도
`Application` 클래스는 `WindowsButton`과 `HTMLButton` 클래스의 존재를 알아야 한다. 이는 클라이언트(`Application`)와 생성될 객체 간의 결합도를 높인다.

## 재사용 불가능
동일한 객체 인스턴스가 필요한 경우, `Application` 클래스에 작성된 조건 분기문을 반복해야 한다.

## 해결 방법: Factory Method 패턴

Factory Method 패턴은 객체 생성 책임을 팩토리 클래스에 위임하여 위 문제를 해결합니다.

## Factory Method 패턴 적용 후

**변경 사항:**
* `WindowsButton`, `HTMLButton` 클래스는 모두 `Button` 인터페이스를 상속받는다.
* `Dialog` 추상 클래스는 `createButton()`이라는 Factory Method를 정의한다.  해당 메서드는 버튼 생성 책임을 하위 클래스에 위임한다.
* `WindowsDialog`와 `HTMLDialog`는 `Dialog`를 상속받아 `createButton()` 메서드를 구현하고, 각각 `WindowsButton`과 `HTMLButton` 객체를 생성한다.
* `Application` 클래스는 더 이상 버튼 생성 로직을 직접 처리하지 않고, `Dialog` 객체를 받아 `render()` 메서드를 호출한다.

**효과:**
* **OCP 준수:** 새로운 버튼 유형을 추가하려면 `Dialog`를 상속받는 새로운 팩토리 클래스를 만들면 된다. `Application` 클래스를 수정할 필요가 없다.
* **낮은 결합도:** `Application` 클래스는 특정 버튼 클래스에 의존하지 않고, `Dialog` 인터페이스를 통해 버튼을 생성합니다.
* **코드 재사용성:** 버튼 생성 로직이 팩토리 클래스에 캡슐화되어 재사용성이 높아집니다.

## 필자의 의견
### OCP 원칙이 과연 지켜졌는가?
**Factory Method**의 적용 후에도 Dialog class를 위한 분기문은 여전히 수정되어야 한다. 그렇다면 이는 **OCP 원칙**이 완전히 지켜졌다고 보기는 어렵지 않을까?
> Factory Method 패턴을 적용한 후에도 `Main` 클래스에서 `Dialog` 객체를 생성하는 분기문은 수정해야 한다. 하지만 이는 객체 생성과 활용을 분리했다는 관점에서 OCP를 준수한다고 볼 수 있겠다. 객체 생성 함수인 `configure`만을 수정하고 `runBusinessLogic`은 수정하지 않아도 된다.

### Factory의 싱글턴
각 클래스를 생성하기 위한 Factory는 하나만 존재해도 무관하다. 즉, Factory는 싱글턴을 활용하여 구현한다면 객체 생성의 캡슐화와 자원 낭비 방지 효과를 볼 수 있다.

### 클래스의 증가
만약에 구현해야 할 클래스의 개수가 증가한다면 어떤 문제가 생길까? `ConcreteProduct` 클래스의 개수가 증가하며 이를 위한 `ConcreteCreator`의 개수 또한 증가한다.

### 추상화를 통한 분기
`framework` 패키지를 보자. 인터페이스와 추상 클래스를 통해 구현했기에 아무리 많은 `ConcreteProduct`가 추가된다고 하여도 수정할 필요가 없다. 이를 두고 `framework` 패키지가 `button` **패키지에 의존하지 않는다**고 한다.
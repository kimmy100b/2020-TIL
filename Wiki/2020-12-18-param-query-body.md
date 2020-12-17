# param VS query VS body

## param

- 주소에 포함된 변수를 담는다.
- https://example.com/post/123이면 123을 담는다.

## query

- 주소에서 ? 이후의 변수를 담는다.
- https://example.com/post?name=springboot이면 springboot를 담는다.

## body

- Json형태로 객체를 담는다.
- 주소에서 확인할 수 없다(주소에서 확인할 수 없음으로 post방식으로 전달할 때 사용된다.)

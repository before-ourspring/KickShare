# KickShare!

### *** TEAM 김말국 : 김민창 안상희 용상호 황지훈 ***

### Motivation
보통 대학교 캠퍼스는 매우 넓고 대중교통도 원활하게 지원되고 있지 않다. 따라서 전동 킥보드 공유 서비스를 대학교에 적용시킴으로써 수업과 수업사이의 짧은 시간내에 넓은 캠퍼스를 보다 편하게 이동할 수 있을 것이며 학교 외부 인근 주변시설도 편하게 이용할 수 있을 것이다.

# Main Issue for Inception phase

## Use Case Diagram

![uc다이어그램](https://user-images.githubusercontent.com/55920132/101247206-71755a80-375b-11eb-9c2d-57006b2ab59e.png)

# Main Issue for Elaboration iteration1

## Domain Model Diagram

![전체도메인모델](https://user-images.githubusercontent.com/55920132/101247220-8baf3880-375b-11eb-862e-183491466f0f.png)

# Main Issue for Elaboration iteraion2

## Sequence Diagram for UC1

- System Operation 1: startRental() : Rental을 위한 시스템 내부 설정을 진행한다.

![1](https://user-images.githubusercontent.com/55920132/101247291-29a30300-375c-11eb-884b-9de490c7a172.png)

- System Operation 2 : checkKickBoard() : 현재 사용자의 위치에서 사용 가능한 KickBoard의 위치를 조회한다.

![2](https://user-images.githubusercontent.com/55920132/101247296-31fb3e00-375c-11eb-9ece-e68e22f898dd.png)

- System Operation 3 : rentKickboard() : 사용자가 KickBoard에 부착된 QRcode를 인식시키면 시스템에게 메시지가 전달된다.

![3](https://user-images.githubusercontent.com/55920132/101247304-37588880-375c-11eb-9812-898c4516ee25.png)

## Main Display

<img src="https://user-images.githubusercontent.com/55920132/101247513-6b807900-375d-11eb-9e01-a03791b6eb28.png"  width="150" height="280"><img src="https://user-images.githubusercontent.com/55920132/101247530-776c3b00-375d-11eb-82e9-4eda97ce5198.png"  width="150" height="280"><img src="https://user-images.githubusercontent.com/55920132/101247540-82bf6680-375d-11eb-9878-e5bd0304f355.png"  width="150" height="280"><img src="https://user-images.githubusercontent.com/55920132/101247558-923eaf80-375d-11eb-8039-ab629c76547d.png"  width="150" height="280">

# Look Back

현재 이 시스템은 주요 requirement를 충족하는 use-case를 가지고 있으며, 각 use-case에 대한 도메인 모델링은 모두 완료되었다. 또한, 도메인 모델을 토대로 한 디자인 모델링도 완료된 상태이다. 다만, 유저의 실제 피드백을 받아 수정하는 부분은 아직 반영되지 않았다. 구현은 현재 약 40% 이상 진행된 상태이며, UI는 사용자가 시스템을 편리하게 사용할 수 있도록 구현되었다. 다만 결제와 포인트의 충전 등 외부 시스템을 사용하는 부분은 아직 UI 상에서 구현이 되지 않은 상태이다. 도메인 부분은 킥보드를  rent 하는 use case와 요금을 calculate하는 use case가 구현되어 있으며,  다른 use case들은 Iteration을 반복하면서 추가적으로 구현이 될 예정이다. 앞으로 더 진행해야 하는 부분으로는, 사용자의 피드백을 받아 수정 혹은 개선해야 하는 부분들이 도메인 모델에 빠르게 반영되어야 하고, 이를 기반으로 디자인과 실제 구현까지 빠르게 수정되어야 한다. 디자인 모델링에서도 계속해서 다른 디자인 패턴을 적용하는 등 더 나은 방향으로 가기 위해 개선되어야 한다. 또한, 킥보드와 통신하는 모듈이나 외부 결제 시스템 등을 사용하기 때문에, 기존의 시스템과, 혹은 다른 외부 시스템과 호환성이 좋은 모델을 찾아 적용해야 한다. 현재 단계에서는 어떤 시스템을 사용할 지는 결정되지 않은 상태이다. UI 부분 또한 사용자의 의견을 반영하여 사용하기 편리하게 개선되어야 한다. 예를 들어, 대여하기 메뉴에 들어간 뒤에 맵을 보여주는 방식과, 사용자는 어차피 대여를 위해 들어오는 것이므로 앱을 실행하면 바로 대여하기 메뉴를 보여주는 방식 중 어떤 방식을 채택할 지 등은 선 구현 후 사용자의 피드백을 받아 변경하여야 하는 문제이다. 

이번 과제를 통해, 우리가 평소에 사용하는 시스템들이 기능의 단순한 구현으로 이루어진 것이 아니라, 사용자 혹은 stakeholder들의 요구사항 분석부터 도메인 모델, 디자인 모델 그리고 다양한 디자인 패턴들의 적용으로 체계적으로 만들어졌다는 사실을 알게 되었다. 또한, 어떤 시스템이던 간에 체계적인 설계와 구현이 얼마나 중요한지도 알게 되었다. 시스템을 여러 부분으로 나누고, 각 부분들이 어떤 방식으로 소통하고 상호작용 하는지를 계획하고 설계하는 것은 매우 복잡하고 어려운 일이지만, 이런 방식으로 설계된 시스템이야 말로 안정적이고 효율적으로 작동할 것임을 느낄 수 있었다. 또한 실제 기업에서는 여러 사업부가 파트를 나눠 설계를 진행하기에, UML을 이용한 도메인 모델링의 효율성이 매우 높을 것임을 예상할 수 있었다. 무엇보다, 이번 팀 프로젝트에서 팀원들 간에 시스템에 대해 말로는 똑같이 표현하고 있었지만 실제로는 다른 것을 생각하고 있는 경우가 매우 많았다. 이런 경우에 다이어그램을 통해 소통하면 훨씬 더 명확하고 빠르게 서로의 의견을 맞춰갈 수 있다는 사실을 알게 되었다. 또, 의욕이 넘쳐 미리미리 해놔도 앞의 부분에서 수정할 부분이 생기면 뒤의 부분을 전부 수정해야 하기 때문에, 한 번에 많이 진행하는 것이 아니라, iteration을 여러 번 반복하면 진행하는 방식이 더 효율적이라는 것을 느끼게 되었다.

# Reference

- 플라워로드 사이트, http://www.flowerroad.ai/
- 운전면허정보 검증 사이트, https://dlv.koroad.or.kr/
- 4+1 view 위키피디아, https://en.wikipedia.org/wiki/4%2B1_architectural_view_model  
- thick client vs thin client, https://simplicable.com/new/thin-client-vs-thick-client 
- 전송 계층 보안, 위키피디아, https://en.wikipedia.org/wiki/전송_계층_보안
- sequence diagram 구성 및 작성법, https://sswpgm.tistory.com/29



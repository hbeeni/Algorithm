# 조합

> DP (Dynamic Programming)

## 점화식 세우기

1. 특정 문제를 가정하기

    - 5개의 데이터 중 3개를 선택하는 조합(<sub>5</sub>C<sub>3</sub>)의 경우의 수를 푸는 문제 가정

2. 모든 부분 문제가 해결된 상황이라고 가정하고 지금 문제 생각하기

    - 5개의 데이터 중 4개 데이터를 선택했다고 가정하고, 가장 마지막 데이터의 선택 여부에 따른 경우의 수를 계산
        1. 마지막 데이터를 포함해 총 3개의 데이터를 선택하려면 = 마지막 데이터를 선택한다면? 선택이 완료됐다고 가정한 4개의 데이터에서 2개를 선택
        2. 마지막 데이터를 포함하지 않고 총 3개의 데이터를 선택하려면 = 마지막 데이터를 선택하지 않는다면? 이전 데이터 4개 중 3개를 선택
    - 위 2가지 경우의 수를 합치면 데이터 5개 중 3개를 선택하는 경우의 수가 나옴
        - <sub>5</sub>C<sub>3</sub> = <sub>4</sub>C<sub>2</sub> + <sub>4</sub>C<sub>3</sub>
        - `D[5][3] = D[4][2] + D[4][3]`

3. 특정 문제를 해결한 내용을 바탕으로 일반 점화식 도출하기
    - `D[i][j] = D[i - 1][j - 1] + D[i - 1][j]`

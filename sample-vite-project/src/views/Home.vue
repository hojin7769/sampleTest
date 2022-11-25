<template>
  <div class="rouletter">
    <div class="rouletter-bg"><div class="rouletter-wacu"></div></div>
    <div class="rouletter-arrow"></div>
    <button class="rouletter-btn">start</button>
  </div>
</template>

<script setup>
var rouletter = {
  // 부여할 숫자 랜덤으로 하기
  random: function () {
    const min = Math.ceil(0)
    const max = Math.floor(5)
    return Math.floor(Math.random() * (max - min)) + min
  },
  // start 버튼
  start: function () {
    const btn = document.querySelector('.rouletter-btn')
    const panel = document.querySelector('.rouletter-wacu')

    panel.classList.add('on')
    btn.innerText = 'stop'
  },
  // stop 버튼
  stop: function () {
    const btn = document.querySelector('.rouletter-btn')
    const panel = document.querySelector('.rouletter-wacu')
    // 돌림판 형태가 6개로 분할되어있어 필요한 각도를 array로 만들었다.
    // 후에 length로 for문으로 돌려서 array처리로 변경하면 보다 동적으로 대처할수 있겠다.
    const deg = [60, 120, 180, 240, 300, 360]

    panel.style.transform = 'rotate(' + deg[rouletter.random()] + 'deg)'
    panel.classList.remove('on')
    btn.innerText = 'start'
  }
}

document.addEventListener('click', function (e) {
  const target = e.target
  if (target.tagName === 'BUTTON') {
    target.innerText === 'start'
      ? rouletter.start()
      : rouletter.stop()
  }
})

</script>

<style scoped>
.rouletter{
  position: relative;
  width:400px;
  height:400px;
}
.rouletter-bg{
  position: absolute;
  top:50%;
  left:50%;
  transform:translate(-50%,-50%);
  width:350px;
  height:350px;
  border-radius:350px;
  overflow:hidden;
}
.rouletter-wacu{
  width:100%;height:100%;
  background:#f5f5f2 url('https://m.lifeplanet.co.kr:444/commons/slink/administrator/openInnovation/img/MO)%20360%ED%94%8C%EB%9E%98%EB%8B%9B_%EB%A3%B0%EB%A0%9B%ED%8C%90_476x476_201026.png') no-repeat;
  background-size:100%;
  transform-origin: center;
}
.rouletter-arrow{
  position: absolute;
  top:0;
  left:50%;
  transform:translateX(-50%);
  width:1px;
  height:1px;
  border-right:10px solid transparent;
  border-left:10px solid transparent;
  border-top:40px solid red;
  border-bottom:0px solid transparent;
}
.rouletter-btn{
  position: absolute;
  top:50%;
  left:50%;
  transform:translate(-50%,-50%);
  width:80px;
  height:80px;
  border-radius:80px;
  background:#fff;
  border-image: linear-gradient(to right, #fbfcb9be, #ffcdf3aa, #65d3ffaa);
  border: 2px solid;
}

   .on{
     animation-name: ani;
     animation-duration: 0.1s;
     animation-fill-mode: forwards;
     animation-iteration-count: infinite;
   }

@keyframes ani{
  0% {
    transform: rotate(0deg);
    transition-timing-function: ease-out;
  }
  100%{
    transform: rotate(360deg);
  }
}

</style>

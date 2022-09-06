<template>
  <div class="tile is-ancestor">
    <div class="tile is-vertical is-8">
      <div class="tile">
        <div class="tile is-parent is-vertical">
          <article class="tile is-child notification is-primary">
            <a href="" style="text-decoration: none;"><p class="title">生活篇</p>
              <p class="subtitle">头条话题</p></a>
          </article>
          <article class="tile is-child notification is-warning">
            <p class="title">学校生活</p>
            <p class="subtitle">大学生的日常</p>
          </article>
        </div>
        <div class="tile is-parent">
          <article class="tile is-child notification is-info">
            <p class="title">娱乐新闻</p>
            <p class="subtitle">综艺、八卦、头条趣事</p>
            <figure class="image is-4by3">
              <img src="../assets/logo.png" width="640px" height="480px">
            </figure>
          </article>
        </div>
      </div>
      <div class="tile is-parent">
        <article class="tile is-child notification is-danger">
          <p class="title">交友圈</p>
          <p class="subtitle">扩充你的朋友圈</p>
          <div class="content">
            <!-- Content -->
          </div>
        </article>
      </div>
    </div>
    <div class="tile is-parent">
      <article class="tile is-child notification is-success">
        <div class="content">
          <p class="title">兴趣爱好篇</p>
          <p class="subtitle">体育、艺术、技术分享</p>
          <div class="content">
            <!-- Content -->
          </div>
        </div>
      </article>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home"
}
</script>

<style scoped>

</style>
<template>

  <div class="404" style="padding: 0.64rem 1rem">
    <a-result status="404" title="404" sub-title="Sorry, the page you visited does not exist.">
      <template #extra>
        <a-button type="primary" >
          <router-link to="/">Back Home</router-link></a-button>
      </template>
    </a-result>
  </div>

</template>
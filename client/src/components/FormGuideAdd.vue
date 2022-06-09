<template>
    <div class="add-destination-form">
        <div class="modal-close-button">
            <div @click="closeModal" class="close-btn"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6"
                    fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="1">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                </svg>
            </div>
        </div>
        <form>
            <div>
                <label for="name">Name</label>
                <input name="name" type="text" v-model="guide.name" />
                <label for="lastName">Last name</label>
                <input name="lastName" type="text" v-model="guide.lastName" />
            </div>

            <label for="address">Address</label>
            <input name="address" type="text" v-model="guide.address" />

            <label for="phone">Phone</label>
            <input name="phone" type="text" v-model="guide.phone" />

            <label for="email">Email</label>
            <input name="email" type="email" v-model="guide.email" />

            <label for="dateOfBirth">Date of birth</label>
            <input name="dateOfBirth" type="date" v-model="guide.dateOfBirth" />

            <div class="button-center">
                <button @click="addGuide" type="button" class="btn secondary">Add Guide</button>
            </div>
        </form>
    </div>
</template>

<script>
import axios from 'axios';
import Loading from './Loading.vue';

export default {
    components: { Loading },
    data() {
        return {
            guide: {
                name: "",
                lastName: "",
                address: "",
                phone: "",
                email: "",
                dateOfBirth: "",
            }
        }
    },
    methods: {
        addGuide() {
            this.loading = true;
            axios
                .post("http://localhost:8080/api/v1/guides/add", this.guide)
                .then(response => {
                    this.guide = response.data;
                    this.loading = false;
                    this.$emit('close');
                })
                .catch(function (error) {
                    console.log(error)
                    this.loading = false;
                })
        },
        closeModal() {
            this.$emit('close')
        },
    }
}
</script>
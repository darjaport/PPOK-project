<template>
    <Loading v-if="loading" />
    <div v-else class="add-destination-form">
        <div class="modal-close-button">
            <div @click="closeModal" class="close-btn"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6"
                    fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="1">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                </svg>
            </div>
        </div>
        <form>
            <label>Name</label>
            <input type="text" v-model="destination.name" />

            <div class="grid-group">
                <span>
                    <label>Groupe size</label>
                    <input type="number" v-model="destination.groupSize" />
                </span>

                <span>
                    <label>Start date</label>
                    <input type="date" v-model="destination.startDate" />
                </span>

                <span>
                    <label>End date</label>
                    <input type="date" v-model="destination.endDate" />
                </span>
            </div>

            <div class="grid-group">
                <span>
                    <label>Price (€)</label>
                    <input type="number" v-model="destination.price" />
                </span>

                <span v-if="difficultyLevels.length > 0">
                    <label>Difficulty level</label>
                    <select v-model="destination.difficultyLevelId">
                        <option v-for="l in difficultyLevels" :key="l.difficultyLevelId" :value="l.difficultyLevelId">
                            {{ l.name }}</option>
                    </select>
                </span>

                <span v-if="guides.length > 0">
                    <label for="destinationGuide">Guide</label>
                    <select id="destinationGuide" name="destinationGuide" v-model="destination.guideId">
                        <option v-for="guide in guides" :key="guide.guideId" :value="guide.guideId">{{ guide.name }} {{
                            guide.lastName }}</option>
                    </select>
                </span>
            </div>

            <div class="grid-group">
                <span>
                    <label>City</label>
                    <input type="text" v-model="destination.cityName" />
                </span>

                <span>
                    <label>Country</label>
                    <input type="text" v-model="destination.countryName" />
                </span>

                <span v-if="continents.length > 0">
                    <label>Continent</label>
                    <select v-model="destination.continentId">
                        <option v-for="continent in continents" :key="continent.continentId"
                            :value="continent.continentId">
                            {{ continent.name }}</option>
                    </select>
                </span>
            </div>

            <label>Description</label>
            <textarea rows="1" type="text" v-model="destination.description" />

            <div class="button-center">
                <button @click="addDestination" type="button" class="btn secondary">Add Destination</button>
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
            loading: true,
            guides: [],
            difficultyLevels: [],
            continents: [],
            destination: {
                name: "",
                description: "",
                price: "",
                groupSize: "",
                startDate: "",
                endDate: "",
                guideId: "",
                cityName: "",
                countryName: "",
                difficultyLevelId: "",
                continentId: ""
            },
        }
    },
    methods: {
        addDestination() {
            this.loading = true;
            axios
                .post("http://localhost:8080/api/v1/destinations/add", this.destination)
                .then(response => {
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
        getData() {
            this.loading = true;
            axios
                .get("http://localhost:8080/api/v1/guides")
                .then(response => {
                    this.guides = response.data;
                })
                .catch(function (error) {
                    console.log(error)
                    this.loading = false;
                });
            axios
                .get("http://localhost:8080/api/v1/continents")
                .then(response => {
                    this.continents = response.data;
                })
                .catch(function (error) {
                    console.log(error)
                    this.loading = false;
                })
            axios
                .get("http://localhost:8080/api/v1/difficultyLevels")
                .then(response => {
                    this.difficultyLevels = response.data;
                    this.loading = false;
                })
                .catch(function (error) {
                    console.log(error)
                    this.loading = false;
                });
        }
    },
    mounted() {
        this.getData();
    }
}
</script>
package com.example.roomdatabase.remote

import com.google.common.truth.Truth.assertThat
import io.mockk.*
import org.junit.Test
import retrofit2.Retrofit

class RetrofitGeneratorTest{

    @Test
    fun contact_retrofitGenerator_notNullCheck_true(){

        mockkObject(RetrofitGenerator)

        val result = RetrofitGenerator.getContactInstance()

        assertThat(result).isNotNull()

    }

    @Test
    fun contact_retrofitGenerator_instanceCheck_true(){
        val retrofit = mockk<Retrofit>()
        mockkObject(RetrofitGenerator)

        every {
            RetrofitGenerator.getContactInstance()
        }returns retrofit

        val result = RetrofitGenerator.getContactInstance()

        assertThat(result).isInstanceOf(Retrofit::class.java)

    }

    @Test
    fun contact_retrofitGenerator_equalityCheck_true(){
        val retrofit = mockk<Retrofit>()
        mockkObject(RetrofitGenerator)

        every {
            RetrofitGenerator.getContactInstance()
        }returns retrofit

        val result = RetrofitGenerator.getContactInstance()

        assertThat(result).isEqualTo(retrofit)

    }


    @Test
    fun event_retrofitGenerator_notNullCheck_true(){

        val retrofit = mockk<Retrofit>()
        mockkObject(RetrofitGenerator)

        every {
            RetrofitGenerator.getEventInstance()
        }returns retrofit

        val result = RetrofitGenerator.getEventInstance()

        assertThat(result).isNotNull()

    }

    @Test
    fun event_retrofitGenerator_instanceCheck_true(){

        val retrofit = mockk<Retrofit>()
        mockkObject(RetrofitGenerator)

        every {
            RetrofitGenerator.getEventInstance()
        }returns retrofit

        val result = RetrofitGenerator.getEventInstance()

        assertThat(result).isInstanceOf(Retrofit::class.java)


    }

    @Test
    fun event_retrofitGenerator_equalityCheck_true(){

        val retrofit = mockk<Retrofit>()
        mockkObject(RetrofitGenerator)

        every {
            RetrofitGenerator.getEventInstance()
        }returns retrofit

        val result = RetrofitGenerator.getEventInstance()

        assertThat(result).isEqualTo(retrofit)

    }

}
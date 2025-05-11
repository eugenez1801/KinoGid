package com.example.kinogid

import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

class LoginValidationTest {
    private val mockRepository = mockk<Repository>()
    val viewModel = AuthViewModel(mockRepository)

    @Test
    fun `обычный адрес`(){
        assertEquals(true, viewModel.isLoginValid("zhenyazl@mail.ru"))
    }

    @Test
    fun `точка в начале`(){
        assertEquals(false, viewModel.isLoginValid(".zhenyazl@mail.ru"))
    }

    @Test
    fun `точка в конце`(){
        assertEquals(false, viewModel.isLoginValid("zhenyazl.@mail.ru"))
    }

    @Test
    fun `две точки подряд`(){
        assertEquals(false, viewModel.isLoginValid("zhen..yazl@mail.ru"))
    }

    @Test
    fun `точка в середине`(){
        assertEquals(true, viewModel.isLoginValid("zhen.yazl@mail.ru"))
    }

    @Test
    fun `три точки`(){
        assertEquals(false, viewModel.isLoginValid("zhen...yazl@mail.ru"))
    }

    @Test
    fun `пустота`(){
        assertEquals(false, viewModel.isLoginValid("@mail.ru"))
    }

    @Test
    fun `пробел в адресе`(){
        assertEquals(false, viewModel.isLoginValid("zheny azl@mail.ru"))
    }

    @Test
    fun `доллар в адресе`(){
        assertEquals(true, viewModel.isLoginValid("zheny\$azl@mail.ru"))
    }

    @Test
    fun `каретка в адресе`(){
        assertEquals(true, viewModel.isLoginValid("zhenyazl^@mail.ru"))
    }


    @Test
    fun `верный номер телефона с 8`(){
        assertEquals(true, viewModel.isLoginValid("89558635123"))
    }

    @Test
    fun `верный номер телефона с +7`(){
        assertEquals(true, viewModel.isLoginValid("+79558635123"))
    }

    @Test
    fun `верный номер телефона с пробелами`(){
        assertEquals(true, viewModel.isLoginValid("8 955 863 51 23"))
    }

    @Test
    fun `верный номер телефона с пробелами с +7`(){
        assertEquals(true, viewModel.isLoginValid("+7 955 863 51 23"))
    }

    @Test
    fun `верный номер телефона с дефисами с +7`(){
        assertEquals(true, viewModel.isLoginValid("+7-955-863-51-23"))
    }

    @Test
    fun `верный номер телефона с дефисами`(){
        assertEquals(true, viewModel.isLoginValid("8-955-863-51-23"))
    }

    @Test
    fun `неверный номер телефона`(){
        assertEquals(false, viewModel.isLoginValid("89558635123ы"))
    }

    @Test
    fun `неверный номер телефона 2`(){
        assertEquals(false, viewModel.isLoginValid("895586351235"))
    }

    @Test
    fun `неверный номер телефона 3`(){
        assertEquals(false, viewModel.isLoginValid("895586351"))
    }

    @Test
    fun `неверный номер телефона 4`(){
        assertEquals(false, viewModel.isLoginValid("8955863512@"))
    }
}
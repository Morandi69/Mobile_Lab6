<p align = "center">МИНИСТЕРСТВО НАУКИ И ВЫСШЕГО ОБРАЗОВАНИЯ
РОССИЙСКОЙ ФЕДЕРАЦИИ
ФЕДЕРАЛЬНОЕ ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ
ОБРАЗОВАТЕЛЬНОЕ УЧРЕЖДЕНИЕ ВЫСШЕГО ОБРАЗОВАНИЯ
«САХАЛИНСКИЙ ГОСУДАРСТВЕННЫЙ УНИВЕРСИТЕТ»</p>
<br><br><br><br><br><br>
<p align = "center">Институт естественных наук и техносферной безопасности<br>Кафедра информатики<br>Чагочкин Никита</p>
<br><br><br>
<p align = "center">Лабораторная работа №6<br>«Версии Android SDK и совместимость».<br>01.03.02 Прикладная математика и информатика</p>
<br><br><br><br><br><br><br><br><br><br><br><br>
<p align = "right">Научный руководитель<br>
Соболев Евгений Игоревич</p>
<br><br><br>
<p align = "center">г. Южно-Сахалинск<br>2023 г.</p>

***
# <p align = "center">1. Вывод версии Android на устройстве   </p>
Добавьте в макет GeoQuiz виджет TextView для вывода уровня API устройства, на котором работает программа. На рисунке показано, как должен выглядеть результат.
***
## <p align = "center">Решение</p>
        versionText=findViewById(R.id.sdkVersionText)
        versionText.setText("SdkVersion is: "+android.os.Build.VERSION.SDK_INT.toString())

# <p align = "center">2.Ограничение подсказок </p>
Ограничьте пользователя тремя подсказками. Храните информацию о том, сколько раз пользователь подсматривал ответ, и выводите количество оставшихся подсказок под кнопкой. Если ни одной подсказки не осталось, то кнопка получения подсказки блокируется.
***
## <p align = "center">Решение</p>
В файле quizeViewModel.kt я добавил переменную, и 2 метода один будет возвращать количество оставшихся подсказок, а второй уменьшать их число

        private var promptCounter=3

        val currentPromptCount:Int
        get()=promptCounter

        fun promtUsed(){
        promptCounter=promptCounter-1
    }

В файле MainActivity.kt переписал метод который обрабатывает результат выполнения 2 активити, если подсказка была использована, то уменьшаем оставшееся кол-во, для кнопки cheatbutton устанавливаем состояние Enable false, если кол-во подсказок >=0, и выводим кол-во оставшихся подсказок

        override fun onActivityResult(requestCode: Int,
                                        resultCode: Int,
                                        data: Intent?) {
                super.onActivityResult(requestCode, resultCode, data)
                if (resultCode != Activity.RESULT_OK) {
                    return
                }
                if (requestCode == REQUEST_CODE_CHEAT) {
                    //quizViewModel.questionBank[quizViewModel.currentIndex].usedCheat  =
                        //data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) ?: false
                    if(data?.getBooleanExtra(EXTRA_ANSWER_SHOWN,false) == true){
                        quizViewModel.promtUsed()
                    }
                    cheatButton.setEnabled(quizViewModel.currentPromptCount>0)
                    promptCountText.setText("Prompt left: "+quizViewModel.currentPromptCount)

                }
            }

![](phone1.png)
![](phone2.png)
## <p align = "center">CodeWars</p>

## [Ссылка на профиль Codewars](https://www.codewars.com/users/NoToxic)

![](codewars1.png)
![](codewars2.png)
![](codewars3.png)
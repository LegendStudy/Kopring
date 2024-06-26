package section3.lec10

abstract class Animal (
    protected val species: String,
    protected open val legCount: Int  // open: 상속받는 클래스에서 필드의 getter를 오버라이드할 때 필요
) {

    abstract fun move()
}

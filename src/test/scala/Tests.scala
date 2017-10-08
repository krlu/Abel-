import org.bu.metcs789.Basics._
import org.bu.metcs789._
import org.scalatest.{FlatSpec, Matchers}

class Tests extends FlatSpec with Matchers {
  "Euclidean Algorithm" should "compute correct values" in {
    val (gcd, _) = GCD(614,513)
    assert(gcd == 1)
    assert(ExtendedGCD(614, 513) == (-193, 231))
    assert(ExtendedGCD(5, 7) == (3,-2))
    assert(ExtendedGCD(5, 15) == (1,0))
    assert(ExtendedGCD(10, 15) == (-1,1))
    assert(ExtendedGCD(9, 16) == (-7,4))
  }
  "Exponentiation Algorithm" should "compute correct values" in {
    assert(FastExp(1, 0) == 1)
    assert(FastExp(2, 0) == 1)
    assert(FastExp(300, 0) == 1)

    assert(FastExp(1, 1) == 1)
    assert(FastExp(1, 2) == 1)
    assert(FastExp(1, 300) == 1)

    assert(FastExp(2,1) == 2)
    assert(FastExp(2,2) == 4)
    assert(FastExp(2,3) == 8)
    assert(FastExp(2,4) == 16)

    assert(FastExp(0,1) == 0)
    assert(FastExp(0,2) == 0)
    assert(FastExp(0,110) == 0)

    assert(FastExp(1,0) == 1)
    assert(FastExp(2,0) == 1)
    assert(FastExp(3,0) == 1)

    assert(FastExp(2,-1) == 0.5)
    assert(FastExp(2,-2) == 0.25)
    assert(FastExp(2,-3) == 0.125)
    assert(Math.abs(FastExp(Math.sqrt(2), 2) - 2) < 0.00000004)
  }

  "Prime Finder" should "Finder Primes" in {
    assert(PrimesLessThanN(4) == List(2,3))
    assert(PrimesLessThanN(6) == List(2,3,5))
    assert(PrimesLessThanN(30) == List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
    assert(PrimesLessThanN(100) ==
      List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97))
  }

  "Primitive Root Finder" should "find primitive roots modulo P" in {
    assert(PrimitiveRoots(2) == List(1))
    assert(PrimitiveRoots(3) == List(2))
    assert(PrimitiveRoots(4) == List(3))
    assert(PrimitiveRoots(5) == List(2,3))
    assert(PrimitiveRoots(11) == List(2,6,7,8))
    assert(PrimitiveRoots(54) == List(5, 11, 23, 29, 41, 47))
    assert(PrimitiveRoots(71) ==
      List(7, 11, 13, 21, 22, 28, 31, 33, 35, 42, 44, 47, 52, 53, 55, 56, 59, 61, 62, 63, 65, 67, 68, 69))

  }

  "Mod Inverse" should "compute mod inverse" in {
    assert(ModInverse(5,8) == 5)
    assert(ModInverse(2,3) == 2)
    assert(ModInverse(3,11) == 4)
  }

  "Baby Step Giant Step" should "compute discrete Log" in {
    assert(DiscreteLog(19)(3,729).get == 6)
    assert(DiscreteLog(19)(2,2048).get == 11)
    assert(DiscreteLog(19)(3,6).get == 8)
    assert(DiscreteLog(18)(3,6).isEmpty)
  }

  "Diffie Hellman" should "compute same key for alice and bob" in {
    val alice = User(4,1, Seq())
    val bob = User(3,1, Seq())
    DiffieHellman(5, 23)(alice, bob)
    assert(alice.sharedKey == 18 && bob.sharedKey == 18)
  }
}
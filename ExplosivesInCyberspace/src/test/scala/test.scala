import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("sample inputs") {
    assert(Main.getDecompressedLength("ADVENT") == 6)
    assert(Main.getDecompressedLength("""A(1x5)BC""") == 7)
    assert(Main.getDecompressedLength("(3x3)XYZ") == 9)
    assert(Main.getDecompressedLength("A(2x2)BCD(2x2)EFG") == 11)
    assert(Main.getDecompressedLength("(6x1)(1x3)A") == 6)
    assert(Main.getDecompressedLength("X(8x2)(3x3)ABCY") == 18)
    assert(Main.getDecompressedLength("(19x14)(3x2)ZTN(5x14)MBPWH") == 266)
  }

  test("sample inputs for part 2") {
    assert(Main.getLength("(3x3)XYZ") == 9)
    assert(Main.getLength("X(8x2)(3x3)ABCY") == 20)
    assert(Main.getLength("(27x12)(20x12)(13x14)(7x10)(1x12)A") == 241920)
    assert(Main.getLength("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN") == 445)
    assert(Main.getLength("(19x14)(3x2)ZTN(5x14)MBPWH") == 1064)
    assert(Main.getLength("(19x14)(3x2)ZTN(5x14)MBPWH(112x2)(20x15)(2x15)AX(7x4)UDNOYNU(7x7)YGJJMBB(59x11)(1x10)Q(29x4)VGDXLQYSEUBZSCXVKJLIDXGHCSQXL(3x15)QMJ(2x15)GA(1x11)N(161x5)(10x8)DNMWSUEGYZ(60x12)(36x10)RFWPBFRPFUUERWOMFVIPLIIVNIKYBEPNAEMO(11x4)DJQYLWDSUYF(28x4)KMFEZNRDVFPALMIBTUSSIKBEDDES(25x4)WHBANBCBSMYYJJYMXMEHSVHLK(8x2)DXMYJAOA(157x8)(81x8)(16x13)UDZKAIWYGRMGTFEL(2x2)MX(4x10)UWEW(18x8)XFETJLTWLMXERLKYZE(10x15)ZZINBFHXMJ(58x7)(2x13)PU(6x9)EKETLU(4x14)PYWO(11x13)QPFDYVKMYQT(6x1)FXYXHT(1x9)UQKPHVIYMXGIJU") == 84115)

    //assert(Main.getDecompressedString("(8x2)(3x3)ABC") == "(3x3)ABC(3x3)ABC")
    //assert(Main.getDecompressedString(Main.getDecompressedString("(8x2)(3x3)ABC")) == "ABCABCABCABCABCABC")

    //assert(Main.getSuperDecompressedLength("(574x14)(567x3)(318x14)(311x8)(22x8)(15x13)IFVDNTIWLQZPKFY(20x9)PIAHRLMWBKSLGRMANIZG38x3)(3x12)FJA(3x14)XBN(1x14)T(8x1)PAYAHPVW(62x13)(2x14)RP(47x12)(13x14)PAHQVKGAOCQSI(5x6)FWNZJ(11x6)UWJGVVVQNDU(137x4)(59x10)(2x15)LU(8x12)JFULFVHX(13x15)JGHVEPFJFRELS(5x9)FMEAD(2x2)UI(1x15)H(10x5)OLOGVCUNVA(42x9)(27x2)TSPUMQILTHKOYJEBYVGMIVNPGYJ(3x13)TOS(233x15)(225x13)(51x7)(32x5)ITOPJLZJXADLZUWWZODCJZSFARRBEVAW(7x13)(2x2)MY(161x7)(11x14)(5x15)NUANI(39x8)(3x2)WFP(24x14)YUXDAFGDGETSMQFKXLNAJUXB(92x1)(15x1)VVBNYVKPYIHGXVW(7x11)SHTQWTV(24x1)MFTWXBQKXYRYVHLNSHYCUCIX(8x10)DLJPXYPL(8x15)DFFGYJOZ") == 0)
    //   assert(Main.getSuperDecompressedLength("(19x14)(3x2)ZTN(5x14)MBPWH(112x2)(20x15)(2x15)AX(7x4)UDNOYNU(7x7)YGJJMBB(59x11)(1x10)Q(29x4)VGDXLQYSEUBZSCXVKJLIDXGHCSQXL(3x15)QMJ(2x15)GA(1x11)N(161x5)(10x8)DNMWSUEGYZ(60x12)(36x10)RFWPBFRPFUUERWOMFVIPLIIVNIKYBEPNAEMO(11x4)DJQYLWDSUYF(28x4)KMFEZNRDVFPALMIBTUSSIKBEDDES(25x4)WHBANBCBSMYYJJYMXMEHSVHLK(8x2)DXMYJAOA(157x8)(81x8)(16x13)UDZKAIWYGRMGTFEL(2x2)MX(4x10)UWEW(18x8)XFETJLTWLMXERLKYZE(10x15)ZZINBFHXMJ(58x7)(2x13)PU(6x9)EKETLU(4x14)PYWO(11x13)QPFDYVKMYQT(6x1)FXYXHT(1x9)UQKPHVIYMXGIJU(574x14)(567x3)(318x14)(311x8)(22x8)(15x13)IFVDNTIWLQZPKFY(20x9)PIAHRLMWBKSLGRMANIZG38x3)(3x12)FJA(3x14)XBN(1x14)T(8x1)PAYAHPVW(62x13)(2x14)RP(47x12)(13x14)PAHQVKGAOCQSI(5x6)FWNZJ(11x6)UWJGVVVQNDU(137x4)(59x10)(2x15)LU(8x12)JFULFVHX(13x15)JGHVEPFJFRELS(5x9)FMEAD(2x2)UI(1x15)H(10x5)OLOGVCUNVA(42x9)(27x2)TSPUMQILTHKOYJEBYVGMIVNPGYJ(3x13)TOS(233x15)(225x13)(51x7)(32x5)ITOPJLZJXADLZUWWZODCJZSFARRBEVAW(7x13)(2x2)MY(161x7)(11x14)(5x15)NUANI(39x8)(3x2)WFP(24x14)YUXDAFGDGETSMQFKXLNAJUXB(92x1)(15x1)VVBNYVKPYIHGXVW(7x11)SHTQWTV(24x1)MFTWXBQKXYRYVHLNSHYCUCIX(8x10)DLJPXYPL(8x15)DFFGYJOZ") == 0)
  }

}

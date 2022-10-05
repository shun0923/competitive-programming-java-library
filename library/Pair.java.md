---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/Swag.java
    title: library/Swag.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateSwag.java
    title: library/TemplateSwag.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/TemplateDynamicSwag_test.java
    title: library/TemplateDynamicSwag_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateSegmentTree_Composite_test.java
    title: library/TemplateSegmentTree_Composite_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\n\nclass\
    \ Pair extends SimpleUtil {\n\t// Pair\n\tpublic static final II npii() { return\
    \ new II(ni(), ni()); }\n\tpublic static final II[] npii(final int n) { final\
    \ II a[] = new II[n]; for(int i = 0; i < n; i ++) a[i] = npii(); return a; }\n\
    \tpublic static final IL npil() { return new IL(ni(), nl()); }\n\tpublic static\
    \ final IL[] npil(final int n) { final IL a[] = new IL[n]; for(int i = 0; i <\
    \ n; i ++) a[i] = npil(); return a; }\n\tpublic static final LI npli() { return\
    \ new LI(nl(), ni()); }\n\tpublic static final LI[] npli(final int n) { final\
    \ LI a[] = new LI[n]; for(int i = 0; i < n; i ++) a[i] = npli(); return a; }\n\
    \tpublic static final LL npll() { return new LL(nl(), nl()); }\n\tpublic static\
    \ final LL[] npll(final int n) { final LL a[] = new LL[n]; for(int i = 0; i <\
    \ n; i ++) a[i] = npll(); return a; }\n\tpublic static final ID npid() { return\
    \ new ID(ni(), nd()); }\n\tpublic static final ID[] npid(final int n) { final\
    \ ID a[] = new ID[n]; for(int i = 0; i < n; i ++) a[i] = npid(); return a; }\n\
    \tpublic static final LD npld() { return new LD(nl(), nd()); }\n\tpublic static\
    \ final LD[] npld(final int n) { final LD a[] = new LD[n]; for(int i = 0; i <\
    \ n; i ++) a[i] = npld(); return a; }\n\tpublic static final DI npdi() { return\
    \ new DI(nd(), ni()); }\n\tpublic static final DI[] npdi(final int n) { final\
    \ DI a[] = new DI[n]; for(int i = 0; i < n; i ++) a[i] = npdi(); return a; }\n\
    \tpublic static final DL npdl() { return new DL(nd(), nl()); }\n\tpublic static\
    \ final DL[] npdl(final int n) { final DL a[] = new DL[n]; for(int i = 0; i <\
    \ n; i ++) a[i] = npdl(); return a; }\n\tpublic static final DD npdd() { return\
    \ new DD(nd(), nd()); }\n\tpublic static final DD[] npdd(final int n) { final\
    \ DD a[] = new DD[n]; for(int i = 0; i < n; i ++) a[i] = npdd(); return a; }\n\
    \tpublic static final class TT<T extends Comparable<? super T>, U extends Comparable<?\
    \ super U>> implements Comparable<TT<T, U>> {\n\t\tpublic T a; public U b;\n\t\
    \tpublic TT() { }\n\t\tpublic TT(final T a, final U b) { this.a = a; this.b =\
    \ b; }\n\n\t\t@Override public final String toString() { return \"(\"+a.toString()+\"\
    , \"+b.toString()+\")\"; }\n\t\t@Override public final int hashCode() { return\
    \ Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic final boolean equals(final\
    \ Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj == null) return\
    \ false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\t\t\tTT\
    \ that = (TT) obj;\n\t\t\tif(this.a.getClass() != that.a.getClass()) return false;\n\
    \t\t\tif(this.b.getClass() != that.b.getClass()) return false;\n\t\t\tif(!this.a.equals(that.a))\
    \ return false;\n\t\t\tif(!this.b.equals(that.b)) return false;\n\t\t\treturn\
    \ true;\n\t\t}\n\t\t@Override public final int compareTo(final TT<T, U> that)\
    \ { int c = (this.a).compareTo(that.a); if(c == 0) c = (this.b).compareTo(that.b);\
    \ return c; }\n\t}\n\tpublic static final class II implements Comparable<II> {\n\
    \t\tpublic int a; public int b;\n\t\tpublic II() { }\n\t\tpublic II(final int\
    \ a, final int b) { this.a = a; this.b = b; }\n\t\t@Override public final String\
    \ toString() { return \"(\"+a+\", \"+b+\")\"; }\n\t\t@Override public final int\
    \ hashCode() { return Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic boolean\
    \ equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj\
    \ == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\t\tII that = (II) obj;\n\t\t\tif(this.a != that.a || this.b != that.b) return\
    \ false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override public final int compareTo(final\
    \ II that) { int c = Integer.compare(this.a, that.a); if(c == 0) c = Integer.compare(this.b,\
    \ that.b); return c; }\n\t}\n\tpublic static final class IL implements Comparable<IL>\
    \ {\n\t\tpublic int a; public long b;\n\t\tpublic IL() { }\n\t\tpublic IL(final\
    \ int a, final long b) { this.a = a; this.b = b; }\n\t\t@Override public final\
    \ String toString() { return \"(\"+a+\", \"+b+\")\"; }\n\t\t@Override public final\
    \ int hashCode() { return Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic boolean\
    \ equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj\
    \ == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\t\tIL that = (IL) obj;\n\t\t\tif(this.a != that.a || this.b != that.b) return\
    \ false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override public final int compareTo(final\
    \ IL that) { int c = Integer.compare(this.a, that.a); if(c == 0) c = Long.compare(this.b,\
    \ that.b); return c; }\n\t}\n\tpublic static final class LI implements Comparable<LI>\
    \ {\n\t\tpublic long a; public int b;\n\t\tpublic LI() { }\n\t\tpublic LI(final\
    \ long a, final int b) { this.a = a; this.b = b; }\n\t\t@Override public final\
    \ String toString() { return \"(\"+a+\", \"+b+\")\"; }\n\t\t@Override public final\
    \ int hashCode() { return Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic boolean\
    \ equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj\
    \ == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\t\tLI that = (LI) obj;\n\t\t\tif(this.a != that.a || this.b != that.b) return\
    \ false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override public final int compareTo(final\
    \ LI that) { int c = Long.compare(this.a, that.a); if(c == 0) c = Integer.compare(this.b,\
    \ that.b); return c; }\n\t}\n\tpublic static final class LL implements Comparable<LL>\
    \ {\n\t\tpublic long a; public long b;\n\t\tpublic LL() { }\n\t\tpublic LL(final\
    \ long a, final long b) { this.a = a; this.b = b; }\n\t\t@Override public final\
    \ String toString() { return \"(\"+a+\", \"+b+\")\"; }\n\t\t@Override public final\
    \ int hashCode() { return Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic boolean\
    \ equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj\
    \ == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\t\tLL that = (LL) obj;\n\t\t\tif(this.a != that.a || this.b != that.b) return\
    \ false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override public final int compareTo(final\
    \ LL that) { int c = Long.compare(this.a, that.a); if(c == 0) c = Long.compare(this.b,\
    \ that.b); return c; }\n\t}\n\tpublic static final class ID implements Comparable<ID>\
    \ {\n\t\tpublic int a; public double b;\n\t\tpublic ID() { }\n\t\tpublic ID(final\
    \ int a, final double b) { this.a = a; this.b = b; }\n\t\t@Override public final\
    \ String toString() { return \"(\"+a+\", \"+b+\")\"; }\n\t\t@Override public final\
    \ int hashCode() { return Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic boolean\
    \ equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj\
    \ == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\t\tID that = (ID) obj;\n\t\t\tif(this.a != that.a || this.b != that.b) return\
    \ false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override public final int compareTo(final\
    \ ID that) { int c = Integer.compare(this.a, that.a); if(c == 0) c = Double.compare(this.b,\
    \ that.b); return c; }\n\t}\n\tpublic static final class LD implements Comparable<LD>\
    \ {\n\t\tpublic long a; public double b;\n\t\tpublic LD() { }\n\t\tpublic LD(final\
    \ long a, final double b) { this.a = a; this.b = b; }\n\t\t@Override public final\
    \ String toString() { return \"(\"+a+\", \"+b+\")\"; }\n\t\t@Override public final\
    \ int hashCode() { return Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic boolean\
    \ equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj\
    \ == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\t\tLD that = (LD) obj;\n\t\t\tif(this.a != that.a || this.b != that.b) return\
    \ false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override public final int compareTo(final\
    \ LD that) { int c = Long.compare(this.a, that.a); if(c == 0) c = Double.compare(this.b,\
    \ that.b); return c; }\n\t}\n\tpublic static final class DI implements Comparable<DI>\
    \ {\n\t\tpublic double a; public int b;\n\t\tpublic DI() { }\n\t\tpublic DI(final\
    \ double a, final int b) { this.a = a; this.b = b; }\n\t\t@Override public final\
    \ String toString() { return \"(\"+a+\", \"+b+\")\"; }\n\t\t@Override public final\
    \ int hashCode() { return Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic boolean\
    \ equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj\
    \ == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\t\tDI that = (DI) obj;\n\t\t\tif(this.a != that.a || this.b != that.b) return\
    \ false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override public final int compareTo(final\
    \ DI that) { int c = Double.compare(this.a, that.a); if(c == 0) c = Integer.compare(this.b,\
    \ that.b); return c; }\n\t}\n\tpublic static final class DL implements Comparable<DL>\
    \ {\n\t\tpublic double a; public long b;\n\t\tpublic DL() { }\n\t\tpublic DL(final\
    \ double a, final long b) { this.a = a; this.b = b; }\n\t\t@Override public final\
    \ String toString() { return \"(\"+a+\", \"+b+\")\"; }\n\t\t@Override public final\
    \ int hashCode() { return Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic boolean\
    \ equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj\
    \ == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\t\tDL that = (DL) obj;\n\t\t\tif(this.a != that.a || this.b != that.b) return\
    \ false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override public final int compareTo(final\
    \ DL that) { int c = Double.compare(this.a, that.a); if(c == 0) c = Long.compare(this.b,\
    \ that.b); return c; }\n\t}\n\tpublic static final class DD implements Comparable<DD>\
    \ {\n\t\tpublic double a; public double b;\n\t\tpublic DD() { }\n\t\tpublic DD(final\
    \ double a, final double b) { this.a = a; this.b = b; }\n\t\t@Override public\
    \ final String toString() { return \"(\"+a+\", \"+b+\")\"; }\n\t\t@Override public\
    \ final int hashCode() { return Objects.hash(a, b); }\n\t\t@Override\n\t\tpublic\
    \ boolean equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\
    \tif(obj == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return\
    \ false;\n\t\t\tDD that = (DD) obj;\n\t\t\tif(this.a != that.a || this.b != that.b)\
    \ return false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override public final int compareTo(final\
    \ DD that) { int c = Double.compare(this.a, that.a); if(c == 0) c = Double.compare(this.b,\
    \ that.b); return c; }\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/Pair.java
  requiredBy:
  - library/TemplateSwag.java
  - library/Swag.java
  timestamp: '2022-10-05 15:32:30+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TemplateSegmentTree_Composite_test.java
  - library/TemplateDynamicSwag_test.java
documentation_of: library/Pair.java
layout: document
redirect_from:
- /library/library/Pair.java
- /library/library/Pair.java.html
title: library/Pair.java
---

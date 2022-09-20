---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/TemplatedSegmentTree.java
    title: library/TemplatedSegmentTree.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/point_set_range_composite
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/TemplatedSegmentTree_Composite_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_set_range_composite\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Mod;\nimport library.TemplatedSegmentTree;\n\
    \npublic class TemplatedSegmentTree_Composite_test extends Solver {\n\tpublic\
    \ static void main(final String[] args) { main(args, new TemplatedSegmentTree_Composite_test());\
    \ }\n\n\tpublic void solve() {\n\t\tMod md = Mod998.md;\n\t\tint n = ni();\n\t\
    \tint q = ni();\n\t\tPairLL f[] = npll(n);\n\t\tTemplatedSegmentTree<PairLL> st\
    \ = new TemplatedSegmentTree<>(f,\n\t\t\t() -> new PairLL(1, 0),\n\t\t\t(ele1,\
    \ ele2) -> new PairLL(md.mul(ele1.a, ele2.a), md.mod(ele2.a * ele1.b + ele2.b)));\n\
    \t\tfor(int i = 0; i < q; i ++) {\n\t\t\tif(ni() == 0) st.set(ni(), npll());\n\
    \t\t\telse {\n\t\t\t\tPairLL p = st.find(ni(), ni());\n\t\t\t\tprtln(md.mod(p.a\
    \ * nl() + p.b));\n\t\t\t}\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Mod.java
  - library/TemplatedSegmentTree.java
  isVerificationFile: true
  path: library/TemplatedSegmentTree_Composite_test.java
  requiredBy: []
  timestamp: '2022-09-20 16:42:37+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TemplatedSegmentTree_Composite_test.java
layout: document
redirect_from:
- /verify/library/TemplatedSegmentTree_Composite_test.java
- /verify/library/TemplatedSegmentTree_Composite_test.java.html
title: library/TemplatedSegmentTree_Composite_test.java
---

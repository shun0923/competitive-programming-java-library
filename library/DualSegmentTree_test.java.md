---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/DualSegmentTree.java
    title: library/DualSegmentTree.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_E
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/DualSegmentTree_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_E\n\
    \npackage library;\n\nimport library.Solver;\nimport library.DualSegmentTree;\n\
    \npublic class DualSegmentTree_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new DualSegmentTree_test()); }\n\n\tpublic void\
    \ solve() {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tDualSegmentTree st = new\
    \ DualSegmentTree(n,\n\t\t\t\t0, (ele1, ele2) -> ele1 + ele2);\n\t\tfor(int i\
    \ = 0; i < q; i ++) {\n\t\t\tif(ni() == 0) st.update(ni() - 1, ni(), nl());\n\t\
    \t\telse prtln(st.get(ni() - 1));\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/DualSegmentTree.java
  isVerificationFile: true
  path: library/DualSegmentTree_test.java
  requiredBy: []
  timestamp: '2022-09-20 17:17:01+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/DualSegmentTree_test.java
layout: document
redirect_from:
- /verify/library/DualSegmentTree_test.java
- /verify/library/DualSegmentTree_test.java.html
title: library/DualSegmentTree_test.java
---

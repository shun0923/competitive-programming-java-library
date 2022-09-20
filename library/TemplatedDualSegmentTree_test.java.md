---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/TemplatedDualSegmentTree.java
    title: library/TemplatedDualSegmentTree.java
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
    RuntimeError: bundler is not specified: library/TemplatedDualSegmentTree_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_E\n\
    \npackage library;\n\nimport library.Solver;\nimport library.TemplatedDualSegmentTree;\n\
    \npublic class TemplatedDualSegmentTree_test extends Solver {\n\tpublic static\
    \ void main(final String[] args) { main(args, new TemplatedDualSegmentTree_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tTemplatedDualSegmentTree<long[]>\
    \ st = new TemplatedDualSegmentTree<>(n,\n\t\t\t\t() -> new long[]{0}, (ele1,\
    \ ele2) -> ele1[0] += ele2[0]);\n\t\tfor(int i = 0; i < q; i ++) {\n\t\t\tif(ni()\
    \ == 0) st.update(ni() - 1, ni(), new long[]{nl()});\n\t\t\telse prtln(st.get(ni()\
    \ - 1)[0]);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/TemplatedDualSegmentTree.java
  isVerificationFile: true
  path: library/TemplatedDualSegmentTree_test.java
  requiredBy: []
  timestamp: '2022-09-20 17:28:38+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TemplatedDualSegmentTree_test.java
layout: document
redirect_from:
- /verify/library/TemplatedDualSegmentTree_test.java
- /verify/library/TemplatedDualSegmentTree_test.java.html
title: library/TemplatedDualSegmentTree_test.java
---

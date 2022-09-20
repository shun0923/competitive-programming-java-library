---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/SegmentTree.java
    title: library/SegmentTree.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/point_add_range_sum
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/SegmentTree_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum\n\
    \npackage library;\n\nimport library.Solver;\nimport library.SegmentTree;\n\n\
    public class SegmentTree_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new SegmentTree_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tSegmentTree st = new SegmentTree(nl(n),\n\
    \t\t\t\t0, (ele1, ele2) -> ele1 + ele2);\n\t\tfor(int i = 0; i < q; i ++) {\n\t\
    \t\tif(ni() == 0) st.update(ni(), nl());\n\t\t\telse prtln(st.find(ni(), ni()));\n\
    \t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/SegmentTree.java
  isVerificationFile: true
  path: library/SegmentTree_test.java
  requiredBy: []
  timestamp: '2022-09-20 16:27:42+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/SegmentTree_test.java
layout: document
redirect_from:
- /verify/library/SegmentTree_test.java
- /verify/library/SegmentTree_test.java.html
title: library/SegmentTree_test.java
---

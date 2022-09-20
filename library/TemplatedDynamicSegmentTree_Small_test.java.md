---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':question:'
    path: library/TemplatedDynamicSegmentTree.java
    title: library/TemplatedDynamicSegmentTree.java
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
    RuntimeError: bundler is not specified: library/TemplatedDynamicSegmentTree_Small_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum\n\
    \npackage library;\n\nimport library.Solver;\nimport library.TemplatedDynamicSegmentTree;\n\
    \npublic class TemplatedDynamicSegmentTree_Small_test extends Solver {\n\tpublic\
    \ static void main(final String[] args) { main(args, new TemplatedDynamicSegmentTree_Small_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tDynamicSegmentTree<Long>\
    \ st = new DynamicSegmentTree<>(n,\n\t\t\t\t() -> 0l, (ele1, ele2) -> ele1 + ele2);\n\
    \t\tfor(int i = 0; i < n; i ++) st.set(i, nl());\n\t\tfor(int i = 0; i < q; i\
    \ ++) {\n\t\t\tif(ni() == 0) st.update(ni(), nl());\n\t\t\telse prtln(st.find(ni(),\
    \ ni()));\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/TemplatedDynamicSegmentTree.java
  isVerificationFile: true
  path: library/TemplatedDynamicSegmentTree_Small_test.java
  requiredBy: []
  timestamp: '2022-09-20 17:46:28+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/TemplatedDynamicSegmentTree_Small_test.java
layout: document
redirect_from:
- /verify/library/TemplatedDynamicSegmentTree_Small_test.java
- /verify/library/TemplatedDynamicSegmentTree_Small_test.java.html
title: library/TemplatedDynamicSegmentTree_Small_test.java
---

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
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/789
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/TemplatedDynamicSegmentTree_test.java\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/789\n\n\
    package library;\n\nimport library.Solver;\nimport library.TemplatedDynamicSegmentTree;\n\
    \npublic class TemplatedDynamicSegmentTree_test extends Solver {\n\tpublic static\
    \ void main(final String[] args) { main(args, new TemplatedDynamicSegmentTree_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tTemplatedDynamicSegmentTree<Long>\
    \ st = new TemplatedDynamicSegmentTree<>(1_000_000_001,\n\t\t\t\t() -> 0l, (ele1,\
    \ ele2) -> ele1 + ele2);\n\t\tlong ans = 0;\n\t\tfor(int i = 0; i < n; i ++) {\n\
    \t\t\tif(ni() == 0) st.update(ni(), nl());\n\t\t\telse ans += st.find(ni(), ni()\
    \ + 1);\n\t\t}\n\t\tprtln(ans);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/TemplatedDynamicSegmentTree.java
  isVerificationFile: true
  path: library/TemplatedDynamicSegmentTree_test.java
  requiredBy: []
  timestamp: '2022-09-20 17:46:28+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TemplatedDynamicSegmentTree_test.java
layout: document
redirect_from:
- /verify/library/TemplatedDynamicSegmentTree_test.java
- /verify/library/TemplatedDynamicSegmentTree_test.java.html
title: library/TemplatedDynamicSegmentTree_test.java
---

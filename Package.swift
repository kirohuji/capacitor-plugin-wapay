// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorPluginWapay",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "CapacitorPluginWapay",
            targets: ["WeAlipayPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "WeAlipayPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/WeAlipayPlugin"),
        .testTarget(
            name: "WeAlipayPluginTests",
            dependencies: ["WeAlipayPlugin"],
            path: "ios/Tests/WeAlipayPluginTests")
    ]
)
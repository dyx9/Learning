//
//  MockupView.swift
//  Mockup
//
//  Created by Yixuan Dai on 10/01/2024.
//

import SwiftUI

struct MockupView: View {
    @State private var showingCustomModal = false

    var body: some View {
        NavigationView {
            ZStack {
                // Main content
                VStack() {
                    ForEach(0..<3, id: \.self) { index in
                        Button(action: {
                            // Define the action for each button here
                        }) {
                            VStack{
                                Text("Button \(index + 1)")
                                    .foregroundColor(.white)
                                    .font(.title)
                                Text("Date - Date")
                                    .foregroundColor(.white)
                            }
                        }
                        .frame(maxWidth: .infinity)
                        .padding()
                        .background(Color.gray)
                        .cornerRadius(10)
                        .padding(.horizontal)
                    }                        
                    Spacer()
                }
                .padding(.top)
                .navigationTitle("Title")
                
                // Dimmed background overlay
                if showingCustomModal {
                    Rectangle()
                        .foregroundColor(.black.opacity(0.5))
                        .edgesIgnoringSafeArea(.all)
                        .onTapGesture {
                            // Optional: Close modal when tapping on dimmed background
                            showingCustomModal = false
                        }
                }
                
                // Fixed '+' button at the bottom-right
                VStack {
                    Spacer()
                    HStack {
                        Spacer()
                        Button(action: {
                            // Show the action sheet when '+' is tapped
                            showingCustomModal = true
                        }) {
                            Text("+")
                                .font(.largeTitle)
                                .frame(width: 60, height: 60, alignment: .center)
                                .foregroundColor(.white)
                                .background(Color.blue)
                                .cornerRadius(30)
                                .padding()
                        }
                    }
                }
                
                // Custom modal view
                if showingCustomModal {
                    VStack {
                        HStack {
                            Button(action: {
                                showingCustomModal = false
                            }) {
                                Image(systemName: "xmark")
                                    .padding()
                                    .foregroundColor(.black)
                            }
                            Spacer()
                        }
                        Text("Custom Action Sheet")
                            .font(.title)
                        Button("Action 1") {
                            // Perform Action 1
                            showingCustomModal = false
                        }
                        .buttonStyle(SimpleButtonStyle())
                        
                        Button("Action 2") {
                            // Perform Action 2
                            showingCustomModal = false
                        }
                        .buttonStyle(SimpleButtonStyle())
                        
                        Spacer()
                    }
                    
                    .frame(maxWidth: .infinity)
                    .background(Color.white)
                    .cornerRadius(15)
                    .shadow(radius: 10)
                    .transition(.move(edge: .bottom))
                    .zIndex(1)
                }
            }
        }
        .animation(.easeInOut, value: showingCustomModal)

    }
}

// Define a simple button style
struct SimpleButtonStyle: ButtonStyle {
    func makeBody(configuration: Configuration) -> some View {
        configuration.label
            .frame(maxWidth: .infinity)
            .foregroundColor(.white)
            .padding()
            .background(Color.gray.opacity(configuration.isPressed ? 0.5 : 1))

    }
}

#Preview {
    MockupView()
}
